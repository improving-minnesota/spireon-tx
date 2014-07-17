package com.opi

class BufferOverrunTagLib {
	static namespace = "bo"

	def row = { attrs, body ->
		def extraClasses = attrs['class']
		if (extraClasses) {
			extraClasses = " $extraClasses"
		} else {
			extraClasses = ""
		}
		out << /<div class="row$extraClasses">/
		out << body()
		out << '</div>'
	}

	def signature = { attrs ->
		if (!attrs.user) {
			throw new IllegalArgumentException("User is required")
		}
		out << "<strong><em>-${attrs.user}</em></strong>"
	}

	def header = { attrs, body ->
		def actions = attrs.action ?: []
		def clazz = ''
		if (actions.contains(params.action)) {
			clazz = 'active'
		}
		out << "<li class=\"$clazz\">"
		out << body()
		out << "</li>"
	}
}
