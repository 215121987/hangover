<%@ include file="/view/common/taglib.jsp" %>
<div class="motopress-wrapper content-holder clearfix">
    <div class="container">
        <div class="row cart">
            <div class="span12" id="content">
                <c:choose>
                    <c:when test="${not empty cart && fn:length(cart)>0}">
                        <%@ include file="/view/pages/shop/cart.jsp"%>
                    </c:when>
                    <c:otherwise>
                        <%@ include file="/view/pages/shop/emptyCart.jsp"%>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
<%--<div class="motopress-wrapper content-holder clearfix">
    <div class="container">
        <div class="row">
            <div class="span12" data-motopress-wrapper-type="content">
                <div class="row">
                    <div class="span9 right right" id="content" data-motopress-type="loop">
                        <div id="post-1915" class="page post-1915 type-page status-publish hentry">
                            <div class="woocommerce">
                                <form action="http://livedemo00.template-help.com/woocommerce_53953/cart/"
                                      method="post">
                                    <table class="shop_table cart" cellspacing="0">
                                        <thead>
                                        <tr>
                                            <th class="product-remove">&nbsp;</th>
                                            <th class="product-thumbnail">&nbsp;</th>
                                            <th class="product-name">Product</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-subtotal">Total</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr class="cart_item">
                                            <td class="product-remove">
                                                <a href="http://livedemo00.template-help.com/woocommerce_53953/cart/?remove_item=5a7f963e5e0504740c3a6b10bb6d4fa5&#038;_wpnonce=11efa0e0ce"
                                                   class="remove" title="Remove this item">&times;</a></td>
                                            <td class="product-thumbnail">
                                                <a href="http://livedemo00.template-help.com/woocommerce_53953/product/product-14/"><img
                                                        width="90" height="90"
                                                        src="http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2013/09/Armand-de-Brignac-Brut-Gold-1.5L-Magnum-4-90x90.png"
                                                        class="attachment-shop_thumbnail wp-post-image"
                                                        alt="Armand de Brignac Brut Gold 1.5L Magnum 4"/></a></td>
                                            <td class="product-name">
                                                <a href="http://livedemo00.template-help.com/woocommerce_53953/product/product-14/">Armand
                                                    de Brignac Brut Gold 1.5L Magnum</a></td>
                                            <td class="product-price">
                                                <span class="amount">&#36;70.00</span></td>
                                            <td class="product-quantity">
                                                <div class="quantity"><input type="number" step="1" min="0" max="150"
                                                                             name="cart[5a7f963e5e0504740c3a6b10bb6d4fa5][qty]"
                                                                             value="1" title="Qty"
                                                                             class="input-text qty text" size="4"/>
                                                </div>
                                            </td>
                                            <td class="product-subtotal">
                                                <span class="amount">&#36;70.00</span></td>
                                        </tr>
                                        <tr>
                                            <td colspan="6" class="actions">
                                                <div class="coupon">
                                                    <label for="coupon_code">Coupon:</label> <input type="text"
                                                                                                    name="coupon_code"
                                                                                                    class="input-text"
                                                                                                    id="coupon_code"
                                                                                                    value=""
                                                                                                    placeholder="Coupon code"/>
                                                    <input type="submit" class="button" name="apply_coupon"
                                                           value="Apply Coupon"/>
                                                </div>
                                                <input type="submit" class="button" name="update_cart"
                                                       value="Update Cart"/> <input type="submit"
                                                                                    class="checkout-button button alt wc-forward"
                                                                                    name="proceed"
                                                                                    value="Proceed to Checkout"/>
                                                <input type="hidden" id="_wpnonce" name="_wpnonce"
                                                       value="11efa0e0ce"/><input type="hidden" name="_wp_http_referer"
                                                                                  value="/woocommerce_53953/cart/"/>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </form>
                                <div class="cart-collaterals">
                                    <div class="cart_totals ">
                                        <h2>Cart Totals</h2>
                                        <table cellspacing="0">
                                            <tr class="cart-subtotal">
                                                <th>Cart Subtotal</th>
                                                <td><span class="amount">&#36;70.00</span></td>
                                            </tr>
                                            <tr class="shipping">
                                                <th>Shipping and Handling</th>
                                                <td>

                                                    Free Shipping <input type="hidden" name="shipping_method[0]"
                                                                         data-index="0" id="shipping_method_0"
                                                                         value="free_shipping" class="shipping_method"/>
                                                </td>
                                            </tr>
                                            <tr class="order-total">
                                                <th>Order Total</th>
                                                <td><strong><span class="amount">&#36;70.00</span></strong></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <form class="shipping_calculator"
                                          action="http://livedemo00.template-help.com/woocommerce_53953/cart/"
                                          method="post">
                                        <h2><a href="#" class="shipping-calculator-button">Calculate Shipping</a></h2>
                                        <section class="shipping-calculator-form">
                                            <p class="form-row form-row-wide">
                                                <select name="calc_shipping_country" id="calc_shipping_country"
                                                        class="country_to_state" rel="calc_shipping_state">
                                                    <option value="">Select a country&hellip;</option>
                                                    <option value="AX">&#197;land Islands</option>
                                                    <option value="AF">Afghanistan</option>
                                                    <option value="AL">Albania</option>
                                                    <option value="DZ">Algeria</option>
                                                    <option value="AD">Andorra</option>
                                                    <option value="AO">Angola</option>
                                                    <option value="AI">Anguilla</option>
                                                    <option value="AQ">Antarctica</option>
                                                    <option value="AG">Antigua and Barbuda</option>
                                                    <option value="AR">Argentina</option>
                                                    <option value="AM">Armenia</option>
                                                    <option value="AW">Aruba</option>
                                                    <option value="AU">Australia</option>
                                                    <option value="AT">Austria</option>
                                                    <option value="AZ">Azerbaijan</option>
                                                    <option value="BS">Bahamas</option>
                                                    <option value="BH">Bahrain</option>
                                                    <option value="BD">Bangladesh</option>
                                                    <option value="BB">Barbados</option>
                                                    <option value="BY">Belarus</option>
                                                    <option value="PW">Belau</option>
                                                    <option value="BE">Belgium</option>
                                                    <option value="BZ">Belize</option>
                                                    <option value="BJ">Benin</option>
                                                    <option value="BM">Bermuda</option>
                                                    <option value="BT">Bhutan</option>
                                                    <option value="BO">Bolivia</option>
                                                    <option value="BQ">Bonaire, Saint Eustatius and Saba</option>
                                                    <option value="BA">Bosnia and Herzegovina</option>
                                                    <option value="BW">Botswana</option>
                                                    <option value="BV">Bouvet Island</option>
                                                    <option value="BR">Brazil</option>
                                                    <option value="IO">British Indian Ocean Territory</option>
                                                    <option value="VG">British Virgin Islands</option>
                                                    <option value="BN">Brunei</option>
                                                    <option value="BG">Bulgaria</option>
                                                    <option value="BF">Burkina Faso</option>
                                                    <option value="BI">Burundi</option>
                                                    <option value="KH">Cambodia</option>
                                                    <option value="CM">Cameroon</option>
                                                    <option value="CA">Canada</option>
                                                    <option value="CV">Cape Verde</option>
                                                    <option value="KY">Cayman Islands</option>
                                                    <option value="CF">Central African Republic</option>
                                                    <option value="TD">Chad</option>
                                                    <option value="CL">Chile</option>
                                                    <option value="CN">China</option>
                                                    <option value="CX">Christmas Island</option>
                                                    <option value="CC">Cocos (Keeling) Islands</option>
                                                    <option value="CO">Colombia</option>
                                                    <option value="KM">Comoros</option>
                                                    <option value="CG">Congo (Brazzaville)</option>
                                                    <option value="CD">Congo (Kinshasa)</option>
                                                    <option value="CK">Cook Islands</option>
                                                    <option value="CR">Costa Rica</option>
                                                    <option value="HR">Croatia</option>
                                                    <option value="CU">Cuba</option>
                                                    <option value="CW">Cura&Ccedil;ao</option>
                                                    <option value="CY">Cyprus</option>
                                                    <option value="CZ">Czech Republic</option>
                                                    <option value="DK">Denmark</option>
                                                    <option value="DJ">Djibouti</option>
                                                    <option value="DM">Dominica</option>
                                                    <option value="DO">Dominican Republic</option>
                                                    <option value="EC">Ecuador</option>
                                                    <option value="EG">Egypt</option>
                                                    <option value="SV">El Salvador</option>
                                                    <option value="GQ">Equatorial Guinea</option>
                                                    <option value="ER">Eritrea</option>
                                                    <option value="EE">Estonia</option>
                                                    <option value="ET">Ethiopia</option>
                                                    <option value="FK">Falkland Islands</option>
                                                    <option value="FO">Faroe Islands</option>
                                                    <option value="FJ">Fiji</option>
                                                    <option value="FI">Finland</option>
                                                    <option value="FR">France</option>
                                                    <option value="GF">French Guiana</option>
                                                    <option value="PF">French Polynesia</option>
                                                    <option value="TF">French Southern Territories</option>
                                                    <option value="GA">Gabon</option>
                                                    <option value="GM">Gambia</option>
                                                    <option value="GE">Georgia</option>
                                                    <option value="DE">Germany</option>
                                                    <option value="GH">Ghana</option>
                                                    <option value="GI">Gibraltar</option>
                                                    <option value="GR">Greece</option>
                                                    <option value="GL">Greenland</option>
                                                    <option value="GD">Grenada</option>
                                                    <option value="GP">Guadeloupe</option>
                                                    <option value="GT">Guatemala</option>
                                                    <option value="GG">Guernsey</option>
                                                    <option value="GN">Guinea</option>
                                                    <option value="GW">Guinea-Bissau</option>
                                                    <option value="GY">Guyana</option>
                                                    <option value="HT">Haiti</option>
                                                    <option value="HM">Heard Island and McDonald Islands</option>
                                                    <option value="HN">Honduras</option>
                                                    <option value="HK">Hong Kong</option>
                                                    <option value="HU">Hungary</option>
                                                    <option value="IS">Iceland</option>
                                                    <option value="IN">India</option>
                                                    <option value="ID">Indonesia</option>
                                                    <option value="IR">Iran</option>
                                                    <option value="IQ">Iraq</option>
                                                    <option value="IM">Isle of Man</option>
                                                    <option value="IL">Israel</option>
                                                    <option value="IT">Italy</option>
                                                    <option value="CI">Ivory Coast</option>
                                                    <option value="JM">Jamaica</option>
                                                    <option value="JP">Japan</option>
                                                    <option value="JE">Jersey</option>
                                                    <option value="JO">Jordan</option>
                                                    <option value="KZ">Kazakhstan</option>
                                                    <option value="KE">Kenya</option>
                                                    <option value="KI">Kiribati</option>
                                                    <option value="KW">Kuwait</option>
                                                    <option value="KG">Kyrgyzstan</option>
                                                    <option value="LA">Laos</option>
                                                    <option value="LV">Latvia</option>
                                                    <option value="LB">Lebanon</option>
                                                    <option value="LS">Lesotho</option>
                                                    <option value="LR">Liberia</option>
                                                    <option value="LY">Libya</option>
                                                    <option value="LI">Liechtenstein</option>
                                                    <option value="LT">Lithuania</option>
                                                    <option value="LU">Luxembourg</option>
                                                    <option value="MO">Macao S.A.R., China</option>
                                                    <option value="MK">Macedonia</option>
                                                    <option value="MG">Madagascar</option>
                                                    <option value="MW">Malawi</option>
                                                    <option value="MY">Malaysia</option>
                                                    <option value="MV">Maldives</option>
                                                    <option value="ML">Mali</option>
                                                    <option value="MT">Malta</option>
                                                    <option value="MH">Marshall Islands</option>
                                                    <option value="MQ">Martinique</option>
                                                    <option value="MR">Mauritania</option>
                                                    <option value="MU">Mauritius</option>
                                                    <option value="YT">Mayotte</option>
                                                    <option value="MX">Mexico</option>
                                                    <option value="FM">Micronesia</option>
                                                    <option value="MD">Moldova</option>
                                                    <option value="MC">Monaco</option>
                                                    <option value="MN">Mongolia</option>
                                                    <option value="ME">Montenegro</option>
                                                    <option value="MS">Montserrat</option>
                                                    <option value="MA">Morocco</option>
                                                    <option value="MZ">Mozambique</option>
                                                    <option value="MM">Myanmar</option>
                                                    <option value="NA">Namibia</option>
                                                    <option value="NR">Nauru</option>
                                                    <option value="NP">Nepal</option>
                                                    <option value="NL">Netherlands</option>
                                                    <option value="AN">Netherlands Antilles</option>
                                                    <option value="NC">New Caledonia</option>
                                                    <option value="NZ">New Zealand</option>
                                                    <option value="NI">Nicaragua</option>
                                                    <option value="NE">Niger</option>
                                                    <option value="NG">Nigeria</option>
                                                    <option value="NU">Niue</option>
                                                    <option value="NF">Norfolk Island</option>
                                                    <option value="KP">North Korea</option>
                                                    <option value="NO">Norway</option>
                                                    <option value="OM">Oman</option>
                                                    <option value="PK">Pakistan</option>
                                                    <option value="PS">Palestinian Territory</option>
                                                    <option value="PA">Panama</option>
                                                    <option value="PG">Papua New Guinea</option>
                                                    <option value="PY">Paraguay</option>
                                                    <option value="PE">Peru</option>
                                                    <option value="PH">Philippines</option>
                                                    <option value="PN">Pitcairn</option>
                                                    <option value="PL">Poland</option>
                                                    <option value="PT">Portugal</option>
                                                    <option value="QA">Qatar</option>
                                                    <option value="IE">Republic of Ireland</option>
                                                    <option value="RE">Reunion</option>
                                                    <option value="RO">Romania</option>
                                                    <option value="RU">Russia</option>
                                                    <option value="RW">Rwanda</option>
                                                    <option value="ST">S&atilde;o Tom&eacute; and Pr&iacute;ncipe
                                                    </option>
                                                    <option value="BL">Saint Barth&eacute;lemy</option>
                                                    <option value="SH">Saint Helena</option>
                                                    <option value="KN">Saint Kitts and Nevis</option>
                                                    <option value="LC">Saint Lucia</option>
                                                    <option value="SX">Saint Martin (Dutch part)</option>
                                                    <option value="MF">Saint Martin (French part)</option>
                                                    <option value="PM">Saint Pierre and Miquelon</option>
                                                    <option value="VC">Saint Vincent and the Grenadines</option>
                                                    <option value="SM">San Marino</option>
                                                    <option value="SA">Saudi Arabia</option>
                                                    <option value="SN">Senegal</option>
                                                    <option value="RS">Serbia</option>
                                                    <option value="SC">Seychelles</option>
                                                    <option value="SL">Sierra Leone</option>
                                                    <option value="SG">Singapore</option>
                                                    <option value="SK">Slovakia</option>
                                                    <option value="SI">Slovenia</option>
                                                    <option value="SB">Solomon Islands</option>
                                                    <option value="SO">Somalia</option>
                                                    <option value="ZA">South Africa</option>
                                                    <option value="GS">South Georgia/Sandwich Islands</option>
                                                    <option value="KR">South Korea</option>
                                                    <option value="SS">South Sudan</option>
                                                    <option value="ES">Spain</option>
                                                    <option value="LK">Sri Lanka</option>
                                                    <option value="SD">Sudan</option>
                                                    <option value="SR">Suriname</option>
                                                    <option value="SJ">Svalbard and Jan Mayen</option>
                                                    <option value="SZ">Swaziland</option>
                                                    <option value="SE">Sweden</option>
                                                    <option value="CH">Switzerland</option>
                                                    <option value="SY">Syria</option>
                                                    <option value="TW">Taiwan</option>
                                                    <option value="TJ">Tajikistan</option>
                                                    <option value="TZ">Tanzania</option>
                                                    <option value="TH">Thailand</option>
                                                    <option value="TL">Timor-Leste</option>
                                                    <option value="TG">Togo</option>
                                                    <option value="TK">Tokelau</option>
                                                    <option value="TO">Tonga</option>
                                                    <option value="TT">Trinidad and Tobago</option>
                                                    <option value="TN">Tunisia</option>
                                                    <option value="TR">Turkey</option>
                                                    <option value="TM">Turkmenistan</option>
                                                    <option value="TC">Turks and Caicos Islands</option>
                                                    <option value="TV">Tuvalu</option>
                                                    <option value="UG">Uganda</option>
                                                    <option value="UA">Ukraine</option>
                                                    <option value="AE">United Arab Emirates</option>
                                                    <option value="GB" selected='selected'>United Kingdom (UK)</option>
                                                    <option value="US">United States (US)</option>
                                                    <option value="UY">Uruguay</option>
                                                    <option value="UZ">Uzbekistan</option>
                                                    <option value="VU">Vanuatu</option>
                                                    <option value="VA">Vatican</option>
                                                    <option value="VE">Venezuela</option>
                                                    <option value="VN">Vietnam</option>
                                                    <option value="WF">Wallis and Futuna</option>
                                                    <option value="EH">Western Sahara</option>
                                                    <option value="WS">Western Samoa</option>
                                                    <option value="YE">Yemen</option>
                                                    <option value="ZM">Zambia</option>
                                                    <option value="ZW">Zimbabwe</option>
                                                </select>
                                            </p>
                                            <p class="form-row form-row-wide">
                                                <input type="text" class="input-text" value=""
                                                       placeholder="State / county" name="calc_shipping_state"
                                                       id="calc_shipping_state"/></p>

                                            <p class="form-row form-row-wide">
                                                <input type="text" class="input-text" value=""
                                                       placeholder="Postcode / Zip" name="calc_shipping_postcode"
                                                       id="calc_shipping_postcode"/>
                                            </p>

                                            <p>
                                                <button type="submit" name="calc_shipping" value="1" class="button">
                                                    Update Totals
                                                </button>
                                            </p>
                                            <input type="hidden" id="_wpnonce" name="_wpnonce"
                                                   value="11efa0e0ce"/><input type="hidden" name="_wp_http_referer"
                                                                              value="/woocommerce_53953/cart/"/>
                                        </section>
                                    </form>
                                </div>
                            </div>
                            <div class="clear"></div>
                            <!--.pagination-->
                        </div>
                        <!--post-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>--%>


<%--<section class="col-lg-9 col-md-8 col-sm-12 cart-left-cotent clearfix">
    <div class="heading-wrapper row">
        <span
            class="col-md-3 col-sm-3 col-xs-12 col-xxs-12 shop-more-link hidden-xs text-uppercase"><a
            data-gaq-event="Cart~$~Continue_shopping" href="/all-products/">Continue Shopping</a></span>

        <div class="col-md-6 col-sm-8 col-xs-12 col-xxs-12 cart-heading">YOUR SHOPPING BAG <span class="cart-items">[ 3 items ] </span>
        </div>
        <span class="col-md-3 col-sm-4 col-xs-12 col-xxs-12 check-info"><a
                data-gaq-event="Cart~$~Check_delivery_info~$~Initiate" data-target="#check-delivery-modal"
                data-url="/cart/check-delivery-Info" data-custom-class="check-delivery" href="javascript:void(0)">Check
            delivery info</a></span>
    </div>
    <div class="product-heading row text-uppercase hidden-xs"><span class="col-md-4 col-sm-8">Products</span><span
            class="col-md-4 col-sm-5 delivery-txt visible-lg-screen text-right">Delivery by</span><span
            class="col-md-4 col-sm-4 text-right">total Amount</span>
    </div>
    <article class="row">
        <section data-config-sku="FL055MA72QPNINDFAS" data-sku="FL055MA72QPNINDFAS-6233134"
                 class="cart-content  text-uppercase clearfix">
            <div class="cart-main clearfix">
                <div class="cart-img-container"><a
                        href="Flying_Machine-Black-Printed-Round-Neck-T-Shirt-1909427.html"><img alt=""
                                                                                                 zoom="http://static2.jassets.com/p/Flying-Machine-Black-Printed-Round-Neck-T-Shirt-2581-7249091-1-undefined.jpg"
                                                                                                 data-src-1280="http://static2.jassets.com/p/Flying-Machine-Black-Printed-Round-Neck-T-Shirt-2581-7249091-1-new_cart.jpg"
                                                                                                 data-src-1024="http://static2.jassets.com/p/Flying-Machine-Black-Printed-Round-Neck-T-Shirt-2581-7249091-1-new_cart.jpg"
                                                                                                 data-src-768="http://static2.jassets.com/p/Flying-Machine-Black-Printed-Round-Neck-T-Shirt-2581-7249091-1-new_cart.jpg"
                                                                                                 data-src-500="http://static2.jassets.com/p/Flying-Machine-Black-Printed-Round-Neck-T-Shirt-2581-7249091-1-new_cart.jpg"
                                                                                                 data-src-320="http://static2.jassets.com/p/Flying-Machine-Black-Printed-Round-Neck-T-Shirt-2581-7249091-1-new_cart.jpg"
                                                                                                 class="thumb loaded"
                                                                                                 src="http://static2.jassets.com/p/Flying-Machine-Black-Printed-Round-Neck-T-Shirt-2581-7249091-1-new_cart.jpg"></a>
                </div>
                <div class="cart-right-main">
                    <div class="row cart-inner-main">
                        <div class="col-md-8 col-sm-9 col-xs-12 col-xxs-12 item-desc">
                            <div class="heading">
                                <div class="item-head-main"><a class="item-heading"
                                                               href="/Flying_Machine-Black-Printed-Round-Neck-T-Shirt-1909427.html">Flying
                                    Machine </a><span class="popover-options"><span
                                        data-content="&lt;p&gt;	Item available for gift wrap &lt;/p&gt;"
                                        data-placement="right" data-trigger="hover" data-container="body" title=""
                                        class="gift-icon-small common-sprite btn-popover m-remove-popover"
                                        data-original-title=""></span><div class="content text-uppercase"><p> Item
                                    available for gift wrap </p></div></span><a class="item-brief text-capitalize"
                                                                                href="/Flying_Machine-Black-Printed-Round-Neck-T-Shirt-1909427.html">Black
                                    Printed Round Neck T-Shirt</a></div>
                                <div class="items-stock off-edit-hide"><span>Size <small class="size">S
                                </small></span><span class="size-separator">|</span><span>Qty <small class="qty">3
                                </small></span><a data-option-selected="4" class="edit"
                                                  data-gaq-event="Cart~$~quantity_edit~$~FL055MA72QPNINDFAS-6233134|edit|3"
                                                  href="javascript:void(0)">EDIT</a></div>
                            </div>
                            <div class="delivery off-edit-hide"><span>Delivery by</span> Mon, 7th Mar</div>
                        </div>
                        <div class="col-md-4 col-sm-3 col-xs-12 col-xxs-12 item-price off-edit-hide"><span
                                class="price"><span class="standard-price">2697</span></span></div>
                        <div class="row col-md-12 col-sm-12 col-xs-12 col-xxs-12 item-btn-wrapper">
                            <div class="item-modified clearfix">
                                <div class="off-edit-hide">
                                    <div class="item-modified-links"><a data-content=".movetoshortlist-warning"
                                                                        data-target="#showmore-modal"
                                                                        data-custom-class="movetoshortlist-warning"
                                                                        data-gaq-event="Cart~$~Move_to_wishlist~$~FL055MA72QPNINDFAS-6233134"
                                                                        class="save move-to-shortlist"
                                                                        href="javascript:void(0)"><span
                                            class="save-later-icon common-sprite"></span>SAVE</a><span
                                            class="separator">|</span><a
                                            data-gaq-event="Cart~$~Remove_SKU~$~FL055MA72QPNINDFAS-6233134"
                                            class="remove" href="javascript:void(0)"><span
                                            class="delete-icon common-sprite"></span>REMOVE</a></div>
                                </div>
                            </div>
                        </div>
                        <div class="cart-edit on-edit-hide clearfix">
                            <div class="col-md-3 col-sm-3 col-xs-12 col-xxs-12">
                                <div class="select-box jabong-dropdown select-quantity">
                                    <div class="custom-select-boxs">SELECT QUANTITY<span class="change-value">3</span>
                                    </div>
                                    <select id="" data-valid="" name="" class="form-control " data-rule=""></select>

                                    <p class="error"></p></div>
                            </div>
                            <div class="col-md-9 col-sm-9 col-xs-12 col-xxs-12 edit-btn">
                                <button data-gaq-event="Cart~$~quantity_edit~$~FL055MA72QPNINDFAS-6233134|save|3"
                                        class="btn btn-primary save-btn" type="button">SAVE
                                </button>
                                <button data-gaq-event="Cart~$~quantity_edit~$~FL055MA72QPNINDFAS-6233134|cancel|3"
                                        data-oldvalue="3" class="btn btn-filled cancel-btn" type="button">CANCEL
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="cart-gift-wrapper clearfix">
            <div class="text-uppercase gift-msg">
                <div class="form-group checkbox-input "><label class="">
                    <div class="custom-checkbox  "><span></span><input type="checkbox"
                                                                       data-gaq-event="Cart~$~gift_wrap~$~Initiate"
                                                                       data-target="#gift-wrap-modal"
                                                                       data-url="/cart/gift-wrap" data-nearclass=".cart"
                                                                       data-custom-class="cart-modal" value=""
                                                                       id="gift-wrap-input" name=""></div>
                    <span></span>
                    <small></small>
                </label></div>
                <span class="gift-icon-large common-sprite"></span><span class="pos-rel "><label for="gift-wrap-input">gift
                wrap your order for <span class="rupee">R</span> 30</label></span></div>
        </section>
        <section class="main-container container-fluid clearfix sale-gift-container">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-xss-12 assure-wrapper">
                <div class="sale-heading"><span class="sale-title">Assured Offers</span></div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-6 sale-gift-block">
                    <figure class="gift-wrapper"><p class="sale-promo"><img
                            data-src-default="http://static.jabong.com/cms/new-site/sbi.gif"
                            src="//static1.jabong.com/live/images/img1x1.png"
                            class="cashback-brand-logo load-in-viewport"></p>
                        <figcaption class="cashback-description"><p class="gift-heading-gift">Extra 5% Cashback Using
                            SBI Cards*</p></figcaption>
                    </figure>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-6 sale-gift-block">
                    <figure class="gift-wrapper"><p class="sale-promo"><img
                            data-src-default="http://static.jabong.com/cms/new-site/paytm-new.gif"
                            src="//static1.jabong.com/live/images/img1x1.png"
                            class="cashback-brand-logo load-in-viewport"></p>
                        <figcaption class="cashback-description"><p class="gift-heading-gift">Extra 10% cashback Using
                            Paytm*</p></figcaption>
                    </figure>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-6 sale-gift-block">
                    <figure class="gift-wrapper"><p class="sale-promo"><img
                            data-src-default="http://static.jabong.com/cms/new-site/grofers-new.gif"
                            src="//static1.jabong.com/live/images/img1x1.png"
                            class="cashback-brand-logo load-in-viewport"></p>
                        <figcaption class="cashback-description"><p class="gift-heading-gift">Shop on Jabong and get 10%
                            off on Grofers*</p></figcaption>
                    </figure>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-6 sale-gift-block">
                    <figure class="gift-wrapper"><p class="sale-promo"><img
                            data-src-default="http://static.jabong.com/cms/new-site/oyo-new.gif"
                            src="//static1.jabong.com/live/images/img1x1.png"
                            class="cashback-brand-logo load-in-viewport"></p>
                        <figcaption class="cashback-description"><p class="gift-heading-gift">Shop on Jabong and get 35%
                            off on OYO rooms*</p></figcaption>
                    </figure>
                </div>
                <div class="col-md-12 col-xs-12 col-xxs-12 assured-offer-terms sale-gift-block">*Refer Jabong Terms
                    &amp; Conditions page
                </div>
            </div>
        </section>
    </article>
</section>



  --%>



















