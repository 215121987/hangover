package com.hangover.java.util;

import com.hangover.java.dto.CartDTO;
import com.hangover.java.dto.ShoppingDTO;
import com.hangover.java.dto.StatusDTO;
import com.hangover.java.exception.HangoverException;
import com.hangover.java.model.ShoppingCartItemEntity;
import com.hangover.java.model.UserEntity;
import com.hangover.java.model.master.Role;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.Cookie;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ashif
 * Date: 10/10/14
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class HangoverUtil implements Constants{

    private static final String ALPHA_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static final String CART_HASH_SEPARATOR ="-";



    public static String getAlphaNumeric(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int ndx = (int) (Math.random() * ALPHA_NUM.length());
            sb.append(ALPHA_NUM.charAt(ndx));
        }
        return sb.toString();
    }

    public static String getTempPassword() {
        return getAlphaNumeric(8);
    }

    public static Long getRoleId(String roleName) {
        Map<String, Long> roleMap = new HashMap<String, Long>();
        roleMap.put(Role.ROLE_SUPER_ADMIN, 1l);
        roleMap.put(Role.ROLE_ADMIN, 2l);
        roleMap.put(Role.ROLE_SUPPLIER, 3l);
        roleMap.put(Role.ROLE_CUSTOMER, 4l);
        roleMap.put(Role.ROLE_STAFF, 5l);
        roleMap.put(Role.ROLE_DELIVERY, 6l);
        roleMap.put(Role.ROLE_SUPPLIER_STAFF, 7l);
        return roleMap.get(roleName);
    }

    public static void processRole(UserEntity userEntity) {
        if (null != userEntity.getRoleName() && userEntity.getRoleName().size() > 0) {
            for (String name : userEntity.getRoleName()) {
                Role role = new Role();
                role.setName(name);
                role.setId(getRoleId(name));
                userEntity.addRole(role);
            }
        }
    }


    private String prepareFilterQuery(Map<String, String> columnNameValue) {
        String filterQuery = "";
        if (null != columnNameValue && columnNameValue.size() > 0) {
            filterQuery = filterQuery + " where ";
            int index = 0;
            for (String key : columnNameValue.keySet()) {
                filterQuery = filterQuery + key + " = '" + columnNameValue.get(key) + "' ";
                index = index + 1;
                if (index < columnNameValue.size()) {
                    filterQuery = filterQuery + " and ";
                }
            }
        }
        return filterQuery;
    }


    public <T> Object invokeGetMethodOnObject(T object, String methodName)
            throws HangoverException {
        Object obj = null;
        Method method;
        try {
            method = object.getClass().getMethod(methodName, new Class[]{});
            obj = (Map<String, String>) method.invoke(object, null);
        } catch (SecurityException e) {
            throw new HangoverException(e);
        } catch (NoSuchMethodException e) {
            throw new HangoverException(e);
        } catch (IllegalArgumentException e) {
            throw new HangoverException(e);
        } catch (IllegalAccessException e) {
            throw new HangoverException(e);
        } catch (InvocationTargetException e) {
            throw new HangoverException(e);
        }
        return obj;
    }

    public static void initializeAssociatedEntity(Object object, String associatedProperty)throws HangoverException  {
        PropertyDescriptor objPropertyDescriptor = null;
        try {
            objPropertyDescriptor = new PropertyDescriptor(associatedProperty, object.getClass());
            Object variableValue = objPropertyDescriptor.getReadMethod().invoke(object);
            System.out.println(variableValue);
        } catch (IntrospectionException e) {
            e.printStackTrace();
            throw new HangoverException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new HangoverException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new HangoverException(e);
        }
    }

    public static void initializeAssociatedEntity(List objects, String associatedProperty) {
        for (Object object : objects)
            initializeAssociatedEntity(object, associatedProperty);
    }

    public static String base64Encode(String token) {
        byte[] encodedBytes = Base64.encode(token.getBytes());
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }


    public static String base64Decode(String token) {
        byte[] decodedBytes = Base64.decode(token.getBytes());
        return new String(decodedBytes, Charset.forName("UTF-8"));
    }

    public static String getCartHash(List<CartDTO> cartDTOs) {
        StringBuilder builder = new StringBuilder();
        String separator = "";
        for (CartDTO cartDTO : cartDTOs) {
            builder.append(separator);
            builder.append(cartDTO.getItemId());
            builder.append("X");
            builder.append(cartDTO.getItemDetailId());
            builder.append("X");
            builder.append(cartDTO.getQuantity());
            separator = CART_HASH_SEPARATOR;
        }
        return base64Encode(builder.toString());
    }


    public static Cookie getCartHashCookie(String contextPath, String cartHash) {
        Cookie cartHashCookie = new Cookie(COOKIES_CART_HASH, cartHash);
        cartHashCookie.setMaxAge(60 * 60 * 24 * 5);
        cartHashCookie.setPath(contextPath);
        return cartHashCookie;
    }


    public static List<CartDTO> getCartDTOFromShoppingCartItems(List<ShoppingCartItemEntity> shoppingCartItems){
        List<CartDTO> cartDTOs = new ArrayList<CartDTO>();
        for(ShoppingCartItemEntity shoppingCartItem : shoppingCartItems){
            CartDTO cartDTO = new CartDTO();
            cartDTO.setId(shoppingCartItem.getId());
            cartDTO.setItemId(shoppingCartItem.getItem().getId());
            cartDTO.setItemDetailId(shoppingCartItem.getItemDetail().getId());
            cartDTO.setSize(shoppingCartItem.getItemDetail().getItemSize());
            cartDTO.setPrice(shoppingCartItem.getItemDetail().getSellingPrice());
            cartDTO.setQuantity(shoppingCartItem.getQuantity());
            cartDTO.setName(shoppingCartItem.getItem().getName());
            cartDTO.setDescription(shoppingCartItem.getItem().getDescription());
            cartDTO.setImageURL(shoppingCartItem.getItem().getImageURL().get(0));
            cartDTOs.add(cartDTO);
        }
        return cartDTOs;
    }

    
    public static List<ShoppingDTO> getShoppingDTOFromCart(List<CartDTO> cartDTOs){
        if(null!=cartDTOs && cartDTOs.size()>0){
            List<ShoppingDTO> shoppingDTOs = new ArrayList<ShoppingDTO>();
            for(CartDTO cartDTO :cartDTOs){
                ShoppingDTO shoppingDTO = new ShoppingDTO();
                shoppingDTO.setId(cartDTO.getId());
                shoppingDTO.setItemId(cartDTO.getItemId());
                shoppingDTO.setItemDetailId(cartDTO.getItemDetailId());
                shoppingDTO.setQuantity(cartDTO.getQuantity());
                shoppingDTOs.add(shoppingDTO);
            }
            return shoppingDTOs;
        }
        return null;
    }

    public static Cookie getCookie(Cookie cookies[], String cookieName){
        if(null!= cookies){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName))
                    return cookie;
            }
        }
        return null;
    }


    public static JSONObject getStatusAsJSON(StatusDTO statusDTO) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", statusDTO.getCode());
        jsonObject.put("message", statusDTO.getMessage());
        return jsonObject;
    }

    public static String generateOrderNumber(Long userId, Long cartId){
        Long num = userId*cartId;
        return getAlphaNumeric(8);
    }

}
