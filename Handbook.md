1. Installer Jenkins avec Docker: voir le doc "Demarrer_Jenkins.docx" (aussi pour la création du conteneur pour Docker registry)
2. Le Jenkinsfile contenu dans le projet permet la création de la pipeline d'intégration continue. Pour comprendre les stages principaux se référer au doc "Description_platforme"
3. Pour créer un conteneur pour les hôtes Ansible et remplir le Inventory fichier, se réferer au doc "Ansible.md"
4. Déployer avec Ansible: dans le doc "Description_platforme", les playbooks utilisés sont décrits en détails. 
5. Lancer le playbook pour Hazelcast en premier: "ansible-playbook -i manu-hosts playbook-hazel.yml". Le service hazelcast sera installé sur le hôte rapporté dans le fichier .yml ("hazelcast_service" dans ce cas), et s'assurer que le correspondant adresse ip (172.17.0.4: voir l'inventory "manu-hosts") soit le même indiqué dans src/main/java/com/orion282/calculatorhazelcast/CalculatorHazelcastApplication.java
6. Une fois que le service Hazelcast est en place, la pipeline d'intégration continue doit s'éxécuter sans erreurs: à chaque fois qu'une commit sera éxécuté sur le repository Github, les phases de compilation et test de l'app seront accomplies.
7. Quand la phase de développement de l'application est terminée, il est possible de déployer l'application par ansible. Avant de executer le  playbook, lancer le build Gradle: ./gradlew build
8. Lancer le playbook pour le calculateur: "ansible-playbook -i manu-hosts playbook-calc.yml". L'app sera installé sur le hôte rapporté dans le fichier .yml (preprod dans ce cas; ip: 172.17.0.3)
9. L'app peut être testé par l'url "http://172.17.0.3:8080/sum?a=11&b=18": ça devrait retourner le résultat (29) après 10 secondes (pour le sleep dans la méthode sum). En répétant ce test le résultat devrait être immédiat, démontrant que le service de caching a fonctionné. C'est le même type de test exécuté en phase d'acceptation test dans la pipeline.

###############################################################################################
-Dans le dossier "kubernetes" il y a des indications su comme est possible utiliser kubernets pour déployer l'application
