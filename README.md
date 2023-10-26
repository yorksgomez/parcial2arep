### DESCRIPCIÓN DEL PROYECTO

El proyecto está funcionando correctamente, se conecta desde el servidor Proxy a los servicio Math con RoundRobin.

Imágen del frontend.

![image](https://github.com/yorksgomez/parcial2arep/assets/23731047/145f9153-ec59-4c97-837d-1dd621426684)

Imagen de unos de los servicios.

![image](https://github.com/yorksgomez/parcial2arep/assets/23731047/2b963e59-87fa-4e3e-98da-7df163a1170c)

## Video de funcionamiento

https://github.com/yorksgomez/parcial2arep/assets/23731047/c047b0aa-5cc4-4dc1-8774-6b9b096be3f5

### LANZAR EN EC2

Se debe ejecutar mvn clean package en cada uno de los proyectos. Esto generará en target un archivo llamado como Math-service-with-dependencies.jar.
Copié estos archivos a descargas por facilidad.
![image](https://github.com/yorksgomez/parcial2arep/assets/23731047/46d591e0-38ce-4a54-8af7-297668611601)

Se debe subir cada archivo por scp a las máquinas virtuales. Esto se puede hacer con el comando scp. Una vez subidos los archivos, se deberá instalar java con sudo yum install java.

Posteriormente, se deben dar valores a las variables de entorno. En los servidores Math se debe poner MATH_PORT y en los servidores y en los servidores Proxy las variables PROXY_PORT y APIS.

En mi caso la configuración es así

## Máquina Math 1

export MATH_PORT=8001

## Máquina Math 2

export MATH_PORT=8002

## Máquina proxy

export PROXY_PORT=8000
export APIS="http://3.91.24.130:8001/;http://3.87.113.197:8002/"

## Ejecutando

Una vez creadas las variables de entorno debe ejecutar los .jar en cada máquina
Esto es posible con el comando java -jar [ejecutable].jar. Es importante recordar que hay que abrir los puertos pertinentes en todas las máquinas.

Imágenes de las máquinas corriendo

Math Service 1
![image](https://github.com/yorksgomez/parcial2arep/assets/23731047/56fe84fb-c16d-470c-b5d3-8f36b65d0fab)

Math Service 2
![image](https://github.com/yorksgomez/parcial2arep/assets/23731047/90779356-f8b4-4475-b8bd-433e119eca5c)

Proxy
![image](https://github.com/yorksgomez/parcial2arep/assets/23731047/a2321ce8-e81d-4869-94dd-8ec16b41828d)

Imagen de las máquinas creadas
![image](https://github.com/yorksgomez/parcial2arep/assets/23731047/28877cf7-c261-4c57-b1f7-1120116249c3)



