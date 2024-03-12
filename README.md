# basa-camel-handson

Ideia principal: Apresentar breviamente o camel, falar q pode ser Java puro, com Quarkus ou Spring Boot (pode ser com jbang para prototipar), que pode ser Camel K (kamelets, kamelet binding e intregration)

Para a apresentacao, a ideia seria mostrar q podemos ir melhorando uma aplicacao de integracao.

Teremos uma aplicacao "front", que recebe requisicoes via Http e envia pro Kafka o body.

Faremos a implementacao inicial com SB, faremos o deploy, mostraremos q a mesma aplicacao implantada pode ser serverless sem qualquer alteracao

PRE:
- Cluster no ar
- Operadores desinstalados
- linha de comando conectado

1. Teremos um OpenShift zerado, sem nd.
   1. Instalar AMQ Streams
   2. Instalar um Kafka autenticação scram-sha-512 e authorization simple
      1. project kafka
      2. Poderia ser sem autenticação, tls, plain, oauth2
   3. Configurar um Tópico
      1. Com replica 4, e ver que ele nao sera criado
   4. Criar um Usuário
      1. Ver a secret que foi criada
   5. Configurar kafka-ui
      1. Mostrar que existe o tópico ordens
2. Criar uma app do zero, com spring boot
   1. app basica
      1. Cria com archetipe publico
      2. coloca pra executar
      3. testa uma alteracao e ve se não aparece
      4. Cria um servico rest em /ordens
         1. restConfiguration().component("servlet").host("localhost").port(8080).bindingMode(RestBindingMode.auto);

      5. Recebe um post com um XML
      6. Converte para json com XJ
      7. Envia pro Kafka
```
camel.component.kafka.brokers=localhost:9092
camel.component.kafka.sasl-jaas-config=org.apache.kafka.common.security.scram.ScramLoginModule required username="my-kafka-user" password="yo3WGhoKWNEqZzIUzxmAPo7YD1qBLAtM";
camel.component.kafka.security-protocol=SASL_PLAINTEXT
camel.component.kafka.sasl-mechanism=SCRAM-SHA-512
```
3. Instalar Pipelines
4. Lembrar da URL
   1. localhost:8080/camel/ordem
5. Instalar serverless
   1. Lembrar do serving e eventing
6. Implantar a aplicacao em outro namespace como serverless
7. Instalar um Novo Kafka
8. Copiar o secret do usuario do primeiro kafka
9.  Criar Kafka Mirror2 no novo namespace
10. Instalar Operador Camel K
11. Criar um kamaletbinding similar a aplicação em SB
12. Utilizar Karavan


Alterar HOSTS

https://setapp.com/how-to/edit-mac-hosts-file

sudo nano /etc/hosts

sudo killall -HUP mDNSResponder

Para criar o log, criar a parti do channel

No serving.knative.dev/v1/Service 
```
- name: camel.component.kafka.brokers
            value: my-cluster-kafka-bootstrap:9092
```
camel.component.kafka.brokers=my-cluster-kafka-bootstrap:9092


2024-03-11 01:03:26,768 WARN [org.apa.kaf.cli.ClientUtils] (Camel (camel-1) thread #1 - KafkaConsumer[ordens]) Couldn't resolve server my-cluster-kafka-bootstrap.my-kafka.svc:9092 from bootstrap.servers as DNS resolution failed for my-cluster-kafka-bootstrap.my-kafka.svc


Debezium
https://debezium.io/documentation/reference/stable/operations/openshift.html