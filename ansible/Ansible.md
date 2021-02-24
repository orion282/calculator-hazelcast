Ci dessous la procedure pour créer avec Docker les seveurs pour déployeer l'application en utilisant Ansible:
1. La seule exigence pour une machines pour être géré par Ansible est d'avoir Python et le SSH Server outil installés. Le Dockerfile dans le dossier "Ansible_host" permis de créer un image pour ces conteneurs. Lancer le commande "docker build -t good_host_keyok_sudo ." pour créer l'image "good_host_keyok_sudo"
2. A partir de l'image crée, est possible créer les conteneurs corrispondants aux hôtes sur lesquel l'application sera deployé: "docker run -d -t --name host_test1 good_host_keyok_sudo"
3. Une foi que les machines ont été crée, utiliser le command "docker inspect host_test1" pour decouvrir l'adresse ip
4. Créer le fichier inventory (par exemple "manu-hosts") en mettant le(s) adresse(s) ip des machines
5. Create the inventory with the created host (i.e. "manu-hosts")
6. Run the playbook by using the command: "ansible-playbook -i manu-hosts playbook-calc.yml"
7. The web app can be tested by using the following url: http://172.17.0.5:8080/sum?a=11&b=18 (according to the "manu-hosts" inventory)
