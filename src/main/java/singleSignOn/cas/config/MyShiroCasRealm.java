package singleSignOn.cas.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author guowy
 * @create 2017-07-11 10:10
 **/

public class MyShiroCasRealm extends CasRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyShiroCasRealm.class);

    @PostConstruct
    public  void initProperty(){}

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
        CasToken casToken = (CasToken) token;
        if(token == null){
            return null;
        }
        String credentials = (String)casToken.getCredentials();
        if(StringUtils.hasText(credentials)){
            return null;
        }
        TicketValidator ticketValidator = ensureTicketValidator();
        try{
            Assertion casAction = ticketValidator.validate(credentials, getCasService());
            AttributePrincipal casPrincipal = casAction.getPrincipal();
            String casName = casPrincipal.getName();
            logger.debug("Validate ticket : {} in CAS server : {} to retrieve user : {}",new Object[]{credentials,getCasServerUrlPrefix(),casName});
            Map<String, Object> casAttributes = casPrincipal.getAttributes();
            casToken.setUserId(casName);
            String rememberMeAttributeName = getRememberMeAttributeName();
            String rememberMeStringValue = (String) casAttributes.get(rememberMeAttributeName);
            boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
            if(isRemembered){
                casToken.setRememberMe(true);
            }
            List<Object> principals = CollectionUtils.asList(casName, casAttributes);
            PrincipalCollection principalCollection = new SimplePrincipalCollection(principals,getName());
            return new SimpleAuthenticationInfo ( principalCollection, credentials);
        }catch (TicketValidationException t){
            throw new CasAuthenticationException("Unable to validate ticket [" + credentials + "]", t);
        }
    }
}
