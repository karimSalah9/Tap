# Tap Task
Please consider :
1-there is no validation for currency as I havn't implemented the currency converters.
2-there is no implementation for mappers and swagger due to lack of time.


Request URL : http://localhost:8080/api/topup
Request Body : 

{"amount":1000,
"currency":"",
"charge_id":"test",
"customerRequest":{"id":1,"customerWalletId":1},
"feesRequest":{"amount":500,"currency":""}

}

Response Body : 
{
    "createdDate": "2022-02-17T11:52:32.269",
    "id": 17,
    "status": "SUCCESS",
    "amount": 1000.0,
    "currency": "",
    "charge_id": "test",
    "customerId": 1,
    "customerWalletId": 1,
    "feesAmount": 500.0,
    "feesCurrency": "",
    "balanceAmount": 2600.0
}
