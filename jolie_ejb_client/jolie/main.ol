include "./interfaces/jolie-ejb-client.iol"

main{
    request.deliveryName = "John Smith";
    request.address.street = "Washinton St";
    request.address.streetNumber = "42";
    request.address.zipCode = "AA352";
	ouputMaterialDocument@JolieEjbClient(request)(response)
}