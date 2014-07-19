import grails.rest.render.xml.*

beans = {
	userRenderer(XmlRenderer, com.opi.User) {
		includes = ['firstName', 'lastName', 'username', 'email']
	}
}