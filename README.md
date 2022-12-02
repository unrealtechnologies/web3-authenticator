# web3-authenticator

### A Spring Boot web service to help authenticate users to a website.

## Project Local Setup

The project springboot run configuration should set up automatically, but in order to get certain api's to work we'll need to manually override them in the configuration settings.

1. Add spring boot configuration override 
2. Add key `httpClients.infura.apikey` and value ${infuraApiKey}

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