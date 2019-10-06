include "console.iol"

type greetingsRequest:void{
    .name: string
    .surname: string
}

type greetingsResponse:void{
    .greetings: string
}

interface GreetingsInterface{
   RequestResponse:
    greetings(greetingsRequest)(greetingsResponse)
}

inputPort TestPort {
  Location: "local"
  Protocol: sodep
  Interfaces: GreetingsInterface
}

outputPort TestOutputPort {
Interfaces: GreetingsInterface
}


execution{ concurrent }

main{
    [greetings(request)(response){
        println@Console("I am inside Jolie")()
        response.greetings = "Hello "  + request.name + " " + request.surname
    }]
}

