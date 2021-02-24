Ci dessous la procedure pour créer avec Docker les seveurs pour déployeer l'application en utilisant Ansible:
1.La seule exigence pour une machines pour être géré par Ansible est d'avoir Python et le SSH Server outil installés. Le Dockerfile dans le dossier 
2.Le seul condition pour un Créer un'image Docker d'un hôte CentOs avec SSH server installé de sorte que il pouisse 

2. Create the docker image by running the following command from the same folder where Dockerfile is saved (see "Host_container" folder for details) by using the command: "docker build -t good_host_keyok_sudo ."
3. Run the container with the configured host to which install the "calculator" Java web app, by the command "docker run -d -t --name host_centos_sudo3 good_host_keyok_sudo"
4. Create the inventory with the created host (i.e. "manu-hosts")
5. Run the playbook by using the command: "ansible-playbook -i manu-hosts playbook-calc.yml"
6. The web app can be tested by using the following url: http://172.17.0.5:8080/sum?a=11&b=18 (according to the "manu-hosts" inventory)
