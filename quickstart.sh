sudo apt update -y && 
sudo apt upgrade -y && 
sudo apt install default-jre default-jdk nginx unzip zip -y && 
curl -s https://get.sdkman.io | bash && 
source "/home/azureuser/.sdkman/bin/sdkman-init.sh" && 
sdk install springboot && 
sdk install gradle 4.5.1 && 
spring init --build=gradle --dependencies=web --name=hello hello-world && 
cd hello-world && 
./gradlew build && 
cd .. &&
git clone https://github.com/ManishSharma-99/spring.git  && 
rm hello-world/src/main/java/com/example/helloworld/HelloApplication.java &&
mv spring/src/main/java/com/example/helloworld/HelloApplication.java hello-world/src/main/java/com/example/helloworld/ &&
sudo mv spring/helloworld.service /etc/systemd/system/ && 
sudo systemctl start helloworld && 
sudo rm /etc/nginx/sites-enabled/default && 
sudo mv spring/default /etc/nginx/sites-enabled/ && 
sudo systemctl restart nginx && 
sudo systemctl daemon-reload
