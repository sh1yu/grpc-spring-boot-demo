package org.psy.practice.grpcdemo.server.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.psy.practice.grpcdemo.api.protobuf.Greeting;
import org.psy.practice.grpcdemo.api.protobuf.MyServiceGrpc;

@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void sayHello(Greeting.HelloRequest request, StreamObserver<Greeting.HelloReply> responseObserver) {
        Greeting.HelloReply reply = Greeting.HelloReply.newBuilder().setMessage("Hello ==> " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
