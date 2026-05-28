package com.ram.cart_service.controller;

import com.ram.cart_service.model.AddToCartRequest;
import com.ram.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/cart")
public class CartController{

    @Autowired
    private CartService cartService;

    @PostMapping("/addProductToCart")
    public ResponseEntity<?> addProductToCart(@RequestBody AddToCartRequest cartRequest, Principal principal){
        return ResponseEntity.ok(

        cartService.addProductToCart(cartRequest,principal.getName())
        );

    }

    @GetMapping("/getCartProds")
    public ResponseEntity<?> getCartProds(Principal principal){
        return ResponseEntity.ok().body(cartService.getCartProducts(principal.getName()));
    }

    @PostMapping("/incNoOfProds/{cartId}")
    public ResponseEntity<?> incNoOfProds(@PathVariable Long cartId) {
        return ResponseEntity.ok().body(cartService.incNoOfProds(cartId));
    }

    @PostMapping("/decNoOfProds/{cartId}")
    public ResponseEntity<?> decNoOfProds(@PathVariable Long cartId) {
        return ResponseEntity.ok().body(cartService.decNoOfProds(cartId));
    }

    @DeleteMapping("/deleteCartProd/{id}")
    public ResponseEntity<?> deleteCartProd(@PathVariable Long id) {
        return ResponseEntity.ok(
                cartService.deleteProdById(id)
        );
    }


}