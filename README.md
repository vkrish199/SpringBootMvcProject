We can use ResponseEntity if we want more control on the Http status codes
and message

We can save image by doing the following:
As part of the post request, we can user form data to send json payload
and image separately.
Use @RequestPart to read product json
Use @RequestPart to read the MultipartFile image
Before saving product we can save the image first:
product.setImageName(image.getOriginalFilename());
product.setImageType(image.getContentType());
product.setImageData(image.getBytes());
