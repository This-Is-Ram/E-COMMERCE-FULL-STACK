package com.ram.cart_service.controller;

import com.ram.cart_service.model.AddToCartRequest;
import com.ram.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/addProductToCart")
    public ResponseEntity<?> addProductToCart(
            @RequestBody AddToCartRequest cartRequest,
            Principal principal
    ) {

        System.out.println(
                "============== ADD TO CART =============="
        );

        System.out.println(
                "PRINCIPAL = " + principal
        );

        System.out.println(
                "PRODUCT ID = " + cartRequest.getProductId()
        );

        System.out.println(
                "QUANTITY = " + cartRequest.getQuantity()
        );

        if (principal == null) {

            System.out.println(
                    "PRINCIPAL IS NULL"
            );

            return ResponseEntity.status(401)
                    .body("Principal is null");
        }

        System.out.println(
                "EMAIL = " + principal.getName()
        );

        try {

            Object response =
                    cartService.addProductToCart(
                            cartRequest,
                            principal.getName()
                    );

            System.out.println(
                    "ADD TO CART SUCCESS"
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            System.out.println(
                    "ADD TO CART ERROR"
            );

            e.printStackTrace();

            return ResponseEntity.status(500)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/getCartProds")
    public ResponseEntity<?> getCartProds(
            Principal principal
    ) {

        System.out.println(
                "GET CART PRINCIPAL = " + principal
        );

        return ResponseEntity.ok(
                cartService.getCartProducts(
                        principal.getName()
                )
        );
    }

    @PostMapping("/incNoOfProds/{cartId}")
    public ResponseEntity<?> incNoOfProds(
            @PathVariable Long cartId
    ) {
        return ResponseEntity.ok(
                cartService.incNoOfProds(cartId)
        );
    }

    @PostMapping("/decNoOfProds/{cartId}")
    public ResponseEntity<?> decNoOfProds(
            @PathVariable Long cartId
    ) {
        return ResponseEntity.ok(
                cartService.decNoOfProds(cartId)
        );
    }

    @DeleteMapping("/deleteCartProd/{id}")
    public ResponseEntity<?> deleteCartProd(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                cartService.deleteProdById(id)
        );
    }
}
