for add product to use amazon s3 bucket 
create a file called application.yml in resources folder and paste the following code and replace the access and secretkey with yours

```yml
amazonProperties:
  endpointUrl: https://s3.ap-south-1.amazonaws.com
  accessKey: XXXXXXXXXXXXX
  secretKey: XXXXXXXXXXXXX
  bucketName: online-shoppping
```