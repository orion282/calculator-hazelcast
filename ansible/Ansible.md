Ci dessous la procédure pour créer avec Docker les serveurs pour déployer l'application en utilisant Ansible:
1. La seule exigence pour une machine pour être géré par Ansible est d'avoir Python et le SSH Server outil installés. Le Dockerfile dans le dossier "Ansible_host" permet de créer une image pour ces conteneurs. Lancer la commande "docker build -t good_host_keyok_sudo ." pour créer l'image "good_host_keyok_sudo"
2. A partir de l'image créée, est possible créer les conteneurs correspondants aux hôtes sur lequel l'application sera déployée: "docker run -d -t --name host_test1 good_host_keyok_sudo". Ces hôtes sont aussi accessibles via ssh grâce au utilisateur "manusamp" (mdp "ciao") qu'est aussi sudoer.
3. Une foi que les machines ont été créées, utiliser le commande "docker inspect host_test1" pour découvrir l'adresse ip
4. Créer le fichier inventory (par exemple "manu-hosts") en mettant le(s) adresse(s) ip des machines
