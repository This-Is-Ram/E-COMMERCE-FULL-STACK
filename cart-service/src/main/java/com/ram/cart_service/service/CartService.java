package com.ram.cart_service.service;


import java.util.List;
import com.ram.cart_service.feign.ProductClient;
import com.ram.cart_service.model.AddToCartRequest;
import com.ram.cart_service.model.CartResponse;
import com.ram.cart_service.model.ProductResponse;
import com.ram.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductClient productClient;

    public ResponseEntity<?> addProductToCart(AddToCartRequest dto, String email) {

        ProductResponse product = productClient.getProductById(dto.getProductId());

        CartResponse cart = new CartResponse();

        cart.setProductId(product.getId());
        cart.setQuantity(dto.getQuantity());
        cart.setPrice(product.getPrice());
        cart.setDescription(product.getDescription());
        cart.setProductName(product.getName());
        cart.setUserEmail(email);
        cart.setImageUrl(product.getImageUrl());
        return ResponseEntity.ok().body(cartRepository.save(cart));



    }

    public List<CartResponse> getCartProducts(String email) {
    return cartRepository.findByUserEmail(email);
}

    public ResponseEntity<?> incNoOfProds(Long cartId) {
        CartResponse cart = cartRepository.findById(cartId).orElseThrow();
        cart.setQuantity(cart.getQuantity() + 1);
        return ResponseEntity.ok().body( cartRepository.save(cart));
    }

    public ResponseEntity<?> decNoOfProds(Long cartId) {

        CartResponse cart = cartRepository.findById(cartId).orElseThrow();

        if(cart.getQuantity() > 1){
            cart.setQuantity(cart.getQuantity() - 1);

            return ResponseEntity.ok(
                    cartRepository.save(cart)
            );
        }

        cartRepository.deleteById(cartId);

        return ResponseEntity.ok(
                "Product Removed From Cart"
        );
    }

    public ResponseEntity<String> deleteProdById(Long id) {
        cartRepository.deleteById(id);
        return ResponseEntity.ok().body("Deleted product with id: " + id);
    }
}
