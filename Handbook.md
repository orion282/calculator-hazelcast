1. Installer Jenkins avec Docker: voir le doc "Demarrer_Jenkins.docx"
2. Le Jenkinsfile contenu dans le projet permet la création de la pipeline d'intégration continue. Pour comprendre les stages principaux se référer au doc "Description_platforme"
3. Pour créer un conteneur pour les hôtes Ansible et remplir le Inventory fichier, se réferer au doc "Ansible.md"
4. Déployer avec Ansible: dans le doc "Description_platforme", les playbooks utilisés sont décrits en détails. 
5. Lancer le playbook pour Hazelcast en premier: "ansible-playbook -i manu-hosts playbook-hazel.yml". Le service hazelcast sera installé sur le hôte rapporté dans le fichier .yml ("test_caching" dans ce cas), et s'assurer que le correspondant adresse ip (172.17.0.4: voir l'inventory "manu-hosts") soit le même indiqué dans src/main/java/com/orion282/calculatorhazelcast/CalculatorHazelcastApplication.java
6. Lancer le build Gradle: ./gradlew build
7. Lancer le playbook pour le calculateur: "ansible-playbook -i manu-hosts playbook-calc.yml". L'app sera installé sur le hôte rapporté dans le fichier .yml (test_app dans ce cas; ip 172.17.0.3)
8. L'app peut être testé par l'url "http://172.17.0.3:8080/sum?a=11&b=18": ça devrait retourner le résultat (29) après 10 secondes (pour le sleep dans le methode sum). En répétant ce test le résultat devrait être immédiat, démostrant que le service de caching a fonctionné. C'est le même type de test executé en phase d'acceptance test dans la pipeline.
9. Une fois que le service Hazelcast et la web app sont en place, la pipeline d'intégration continue doit se executer sans erreurs!
