service-name := pokedex-api-2
image := $(service-name)-img
container := $(service-name)-con
port_in := 8081
port_out := 62000
jar_name := pokedex-0.0.1-SNAPSHOT.jar
docker_memory := 1024MB
java_memory := -Xmx1024m

all: build run

pre-build:
	mvn package

test:
	mvn test

clean-images-not-used:
	-docker images -a --no-trunc | grep 'none' | awk '{print $3}' | xargs docker rmi

clean-container-not-used:
	-docker ps --filter status=dead --filter status=exited -qa | xargs docker rm -f

clean:
	-docker stop $(container)
	-docker rm $(container)

local: clean pre-build
	mkdir -p build/libs
	cp target/$(jar_name) build/libs/${jar_name}
	docker build --build-arg JAVA_MEM=$(java_memory) --build-arg JAR_FILE=build/libs/$(jar_name) --tag $(image):latest .

qa:
	mkdir -p build/libs
	cp target/$(jar_name) build/libs/${jar_name}
	docker build --build-arg JAVA_MEM=$(java_memory) --build-arg JAR_FILE=build/libs/$(jar_name) --tag $(image):latest .

prod:
	mkdir -p build/libs
	cp target/$(jar_name) build/libs/${jar_name}
	docker build --build-arg JAVA_MEM=$(java_memory) --build-arg JAR_FILE=build/libs/$(jar_name) --tag $(image):latest .

run:
	mkdir -p build/libs
	cp target/$(jar_name) build/libs/${jar_name}
	docker run -m $(docker_memory) --name $(container) -d -p $(port_out):$(port_in) $(image):latest

run-profiling:
	docker run -m $(docker_memory) --name $(container) -d -p $(port_out):$(port_in) -p 5000:5000 -e JAVA_TOOL_OPTIONS="-Djava.rmi.server.hostname=0.0.0.0 -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=5000 -Dcom.sun.management.jmxremote.rmi.port=5000 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -XX:NativeMemoryTracking=summary" -e NMT_LEVEL_1="summary" $(image):latest

runlocal: clean local run

