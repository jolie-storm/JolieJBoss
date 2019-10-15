type OuputMaterialDocumentRequest:void{
  .deliveryName: string
  .address:void{
    .street:string
    .streetNumber:string
    .zipCode:string
  }
}


type OuputMaterialDocumentResponse:string

interface JolieEjbClientInterface{
RequestResponse:
  ouputMaterialDocument(OuputMaterialDocumentRequest)(OuputMaterialDocumentResponse)
}

outputPort JolieEjbClient {
	Interfaces: JolieEjbClientInterface
}

embedded {
Java:
	"org.jolie.jolie_ejb.JolieEjbClient" in JolieEjbClient
}