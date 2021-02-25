FROM treasureboat/ssh

COPY CentOS-Base.repo /etc/yum.repos.d

RUN yum -y install sudo

RUN useradd manusamp -p "$(openssl passwd -1 ciao)"

WORKDIR /home/manusamp/.ssh
COPY id_rsa.pub ./authorized_keys
COPY sudoers /etc/sudoers
