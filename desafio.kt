// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Matrícula realizada com sucesso para ${usuario.nome} na formação $nome.")
        } else {
            println("${usuario.nome} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    // Criando alguns usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")

    // Criando alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados", 120)
    val conteudo3 = ConteudoEducacional("Estruturas de Dados", 90)

    // Criando uma formação
    val formacao = Formacao("Ciência da Computação", listOf(conteudo1, conteudo2, conteudo3))

    // Matriculando usuários na formação
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Tentando matricular o mesmo usuário novamente

    // Exibindo inscritos na formação
    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos.map { it.nome }}")
}
