package io.iotproj.weatherapp;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
* Since there is no MAIN method in this application ,
* We have to extend AbstractAnnotationConfigDispatcherServletInitializer which
* then be used to configure the 'Configuration' file
*/
public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	/*
     * Specifies the location where the root application configuration are stored.
     * There can be multiple configuration files.
     */
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{Application.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		/*
	        * To inform the application that all of the request will have prefix as "/weatherapi/*"
	        * This prefix could be different as well
	        * */
		return new String[]{"/weatherapi/*"};
	}

}
