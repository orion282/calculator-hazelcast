1. Create the docker image by running the following command from the same folder where Dockerfile is saved (see "Host_container" folder for details) by using the command: "docker build -t good_host_keyok_sudo ."
2. Run the container with the configured host to which install the "calculator" Java web app, by the command "docker run -d -t --name host_centos_sudo3 good_host_keyok_sudo"
3. Create the inventory with the created host (i.e. "manu-hosts")
4. Run the playbook by using the command: "ansible-playbook -i manu-hosts playbook-calc.yml"
5. The web app can be tested by using the following url: http://172.17.0.5:8080/sum?a=11&b=18 (according to the "manu-hosts" inventory)
