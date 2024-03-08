# basa-camel-handson

Ideia principal: Apresentar breviamente o camel, falar q pode ser Java puro, com Quarkus ou Spring Boot (pode ser com jbang para prototipar), que pode ser Camel K (kamelets, kamelet binding e intregration)

1. Teremos um OpenShift zerado, sem nd
   1. Instalar AMQ STreams
   2. Instalar um Kafka com usuário e senha
   3. Configurar um Tópico
   4. Configurar kafka-ui
2. Criar uma app do zero, com spring boot
   1. app basica
      1. Cria com archetipe publico
      2. coloca pra executar
      3. testa uma alteracao e ve se já aparece 
   2. Alterar a app para ler do kafka, e fazer um post para rest https://echo-api.3scale.net/ e LOGAR a resposta (ou colocar em outra fila)
   3. Avaliar se crio um Processor
3. Criar um kamaletbinding similar a aplicação em SB
4. Utilizar Kaoto (avaliar o operator)