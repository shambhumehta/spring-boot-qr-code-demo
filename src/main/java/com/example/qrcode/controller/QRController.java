package com.example.qrcode.controller;



import java.awt.image.BufferedImage;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@RestController
@RequestMapping("/qr")
public class QRController {
	
	@GetMapping(path="/generate",produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage getQRCode(@RequestParam String qrText) throws Exception{
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix= qrCodeWriter.encode(qrText, BarcodeFormat.QR_CODE, 250, 250);
		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	

}
