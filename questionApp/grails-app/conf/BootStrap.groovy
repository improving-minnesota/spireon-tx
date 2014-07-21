class BootStrap {

    def init = { servletContext ->
        // Ensure the ROLE_USER and ROLE_ADMIN authorities exists
        com.opi.Role.findOrSaveByAuthority('ROLE_USER')
        com.opi.Role.findOrSaveByAuthority('ROLE_ADMIN')
    }
    def destroy = {
    }
}
