package com.opi

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.authentication.dao.NullSaltSource
import grails.plugin.springsecurity.ui.RegisterCommand as UiRegisterCommand
import grails.plugin.springsecurity.ui.RegisterController as UiRegister
import grails.plugin.springsecurity.ui.RegistrationCode

class RegisterController extends UiRegister {

	def registerForm() {
		Map copy = [:] + (flash.chainedParams ?: [:])
		copy.remove 'controller'
		copy.remove 'action'
        render view: 'index', model: [command: new RegisterCommand(copy)]
	}

	def newRegister(RegisterCommand command) {

		if (command.hasErrors()) {
			render view: 'index', model: [command: command]
			return
		}

		String salt = saltSource instanceof NullSaltSource ? null : command.username
		User user = new User(
				firstName: command.firstName,
				lastName: command.lastName,
				email: command.email,
				username: command.username,
				accountLocked: true,
				enabled: true
		)

		RegistrationCode registrationCode = springSecurityUiService.register(user, command.password, salt)
		if (registrationCode == null || registrationCode.hasErrors()) {
			// null means problem creating the user
			flash.error = message(code: 'spring.security.ui.register.miscError')
			flash.chainedParams = params
			redirect action: 'index'
			return
		}

		String url = generateLink('verifyRegistration', [t: registrationCode.token])

		def conf = SpringSecurityUtils.securityConfig
		def body = conf.ui.register.emailBody
		if (body.contains('$')) {
			body = evaluate(body, [user: user, url: url])
		}
		mailService.sendMail {
			to command.email
			from conf.ui.register.emailFrom
			subject conf.ui.register.emailSubject
			html body.toString()
		}

		render view: 'index', model: [emailSent: true]
	}

}

class RegisterCommand extends UiRegisterCommand {

	String username
	String email
	String firstName
	String lastName
	String password
	String password2

	def grailsApplication

	static constraints = {
		username blank: false, validator: { value, command ->
			if (value) {
				if (User.findByUsername(value)) {
					return 'registerCommand.username.unique'
				}
			}
		}
		firstName nullable: false, blank: false, maxSize: 30,
			validator: { value, command ->
				if ((value?.toLowerCase() == 'justin')
					&& (command.lastName?.toLowerCase() == 'bieber')) {
					return 'no.biebers.allowed'
				}
			}
		lastName nullable: false, blank: false, maxSize: 30
		email blank: false, email: true
		password blank: false, validator: UiRegister.passwordValidator
		password2 validator: UiRegister.password2Validator
	}
}
