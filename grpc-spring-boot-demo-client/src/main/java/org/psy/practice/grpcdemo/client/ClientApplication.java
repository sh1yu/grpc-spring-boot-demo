package org.psy.practice.grpcdemo.client;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.psy.practice.grpcdemo.api.protobuf.Greeting;
import org.psy.practice.grpcdemo.api.protobuf.MyServiceGrpc;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @GrpcClient("myService")
    private MyServiceGrpc.MyServiceBlockingStub myServiceStub;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return (args) -> {
            Greeting.HelloRequest request = Greeting.HelloRequest.newBuilder().setName("boy").build();
            System.out.println(myServiceStub.sayHello(request).getMessage());
        };
    }
}
