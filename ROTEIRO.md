1. KAFKA
   1. Operador
   2. Kafka
   3. KafkaTopic
   4. KaftaUser
   5. KafkaUI
2. Criar app no repositório viniciusfcf/eda-101-handson
   1. App inicial a partir de um archetype
   2. Inicializar ela
   3. Cria um servico rest em /ordens
         1. restConfiguration().component("servlet").host("localhost").port(8080).bindingMode(RestBindingMode.auto);
   4. Recebe um post com um XML
   5. Converte para json com XJ
      1. Testar com Postman
   6. Enviar pro Kafka
      1. Testar com oc port-forward
   7. Push pro Git
   8. Instalar Pipelines
   9. s2i
3.  Instalar Serverless
4.  Deploy da mesma app em outro project como Serverless
5.  MirrorMaker
    1.  Criar novo kafka no projeto kafka-remoto
    2.  Copiar secret para o novo project
    3.  Criar Kafka mirror
6.  Camel K
    1.  Instalar Operador
    2.  Implantar KB
7.  Karavan/Kaoto
    1.  Conectar no OCP, project kafka-remoto
    2.  Criar integration e publicar