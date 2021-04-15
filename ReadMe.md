# Online Shopping

## Files used for jwt token implemention: 
```java
1. Application.java -> 'HelloWorldController'
2. SecurityConfigurer.java
3. MyUserDetailsService.java
4. AuthenticateRequest.java
5. AuthenticationResponse.java
6. JwtUtil.java
7. JwtRequestFilter.java 
```

## Files used for implementing file-upload on Amazon S3 Bucket :
```java
1. BucketController.java -> 'in controller'
1. AmazonClient.java -> 'in Service layer'
2. Application.yml -> 'in src/main/resources/'
```

for add product to use amazon s3 bucket 
create a file called application.yml in resources folder and paste the following code and replace the access and secretkey with yours

```yml
amazonProperties:
  endpointUrl: https://s3.ap-south-1.amazonaws.com
  accessKey: XXXXXXXXXXXXX
  secretKey: XXXXXXXXXXXXX
  bucketName: online-shoppping
```

