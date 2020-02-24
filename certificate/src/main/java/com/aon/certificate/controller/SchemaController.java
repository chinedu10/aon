package com.aon.certificate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aon.certificate.service.SchemaService;

@RestController
public class SchemaController {
     @Autowired
     SchemaService schemaService;
 
     @GetMapping("/all")
     public ResponseEntity<?> getAll() {
         return ResponseEntity.ok(schemaService.getAll());
     }
 
 }