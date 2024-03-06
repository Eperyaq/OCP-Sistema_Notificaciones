enum class TIPONOTIFICACION{
    EMAIL,
    SMS,
    PUSH,
    WHATSAPP,
    MD
}

interface enviarMensaje{
    fun enviarmensaje(usuario: Usuario2, mensaje: String){
        println("Enviando ${usuario.tipoNotificacion} a ${usuario.nombre}: $mensaje")

    }

}


class Notificador {

    fun enviarNotificacion(usuario: Usuario, mensaje: String) {
        when (usuario.tipoNotificacion) {
            "email" -> println("Enviando correo electrónico a ${usuario.email}: $mensaje")
            "sms" -> println("Enviando SMS a ${usuario.telefono}: $mensaje")
            else -> println("No se ha encontrado via para enviar el mensaje")
            // Para añadir un nuevo método de notificación, debes modificar esta clase.
        }
    }
}

class EnviarMensajes: enviarMensaje{
    override fun enviarmensaje(usuario: Usuario2, mensaje: String) {
        super.enviarmensaje(usuario, mensaje)
    }
}

data class Usuario(val nombre: String, val email: String, val telefono: String, val tipoNotificacion: String)
data class Usuario2(val nombre: String, val email: String, val telefono: String, val tipoNotificacion: TIPONOTIFICACION)

// Uso
fun main() {
    val usuario = Usuario("Juan", "juan@example.com", "1234567890", "email")
    val usuario2 = Usuario2("Pedro","pedro@ejemplo.com","1231231232", TIPONOTIFICACION.WHATSAPP)

    Notificador().enviarNotificacion(usuario, "¡Bienvenido a nuestro sistema!")
    EnviarMensajes().enviarmensaje(usuario2,"Hola, bienvenido!")
}