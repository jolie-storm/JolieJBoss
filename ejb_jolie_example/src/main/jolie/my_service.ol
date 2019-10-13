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

init{
global.counter= 0
}


execution{ concurrent }

main{
    [greetings(request)(response){
        global.counter = global.counter +1
        println@Console("You called number of time "  + global.counter)()
        response.greetings = "Hello "  + request.name + " " + request.surname
    }]
}

