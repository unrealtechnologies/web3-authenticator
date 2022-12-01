# web3-authenticator

### A Spring Boot web service to help authenticate users to a website.

## Api Response

Successful responses have a 2xx statuc code with a payload object.

```json
{
  "payload" : { }
}
```

Failed responses have a non 2xx status code with an error payload.

```json
{
  "error" : { 
    "message" : ""
  }
}
```