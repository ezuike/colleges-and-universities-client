package cn.gov.zcy.config;

import com.neusoft.cas.AuthenticationFilter;
import com.neusoft.cas.Cas20ProxyReceivingTicketValidationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    /**
     * 	该过滤器用于实现单点登出功能，可选设备。
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean singleSignOutFilterBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new SingleSignOutFilter());
        registrationBean.setName("CAS Single Sign Out Filter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean casAuthenticationFilterBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new AuthenticationFilter());
        registrationBean.setName("CASAuthenticationFilter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registrationBean;
    }

    /**
     * 该过滤器负责对Ticket的校验工作，必须启用它
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean SingleSignOutFilterBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Cas20ProxyReceivingTicketValidationFilter());
        registrationBean.setName("CASValidationFilter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registrationBean;
    }

    /**
     * 该过滤器负责实现HttpServletRequest恳求的包裹， 比如容许开辟者经由过程HttpServletRequest的getRemoteUser()办法获得SSO登录用户的登录名，可选设备。
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean casHttpServletRequestWrapperFilterBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new HttpServletRequestWrapperFilter());
        registrationBean.setName("CASHttpServletRequestWrapperFilter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registrationBean;
    }
}
