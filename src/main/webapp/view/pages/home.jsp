<%@ include file="../common/taglib.jsp" %>
<script type="text/javascript">
    jQuery(document).ready(function ($) {
        if (!device.mobile() && !device.tablet()) {
            liteModeSwitcher = false;
        } else {
            liteModeSwitcher = true;
        }
        if ($.browser.msie && parseInt($.browser.version) < 9) {
            liteModeSwitcher = true;
        }
        jQuery('#parallax-slider').parallaxSlider({
            parallaxEffect:"parallax_effect_normal",
            parallaxInvert:false, animateLayout:"simple-fade-eff",
            duration:1500, autoSwitcher:true, autoSwitcherDelay:10000,
            scrolling_description:true, slider_navs:false,
            slider_pagination:"buttons_pagination",
            liteMode:liteModeSwitcher
        });
    });
</script>
<div id="parallax-slider" class="parallax-slider">
    <ul class="baseList">
        <li data-preview="<c:url value="/images/banner/item-banner-3.jpg" />"
            data-thumb-url="<c:url value="/images/banner/item-banner-3-100x50.jpg" />"
            data-ulr-link="">
            <div class="slider_caption">
                <div class="caption_wrapper">
                    <div class="caption_up">
                        <div class="caption_up_content">
                            <h3>Get up to<br> 20% off</h3>
                            <h4>on Wiskey</h4>
                            <h5>more than 50 items</h5>
                        </div>
                    </div>
                    <div class="caption_down">
                        <a class="round-button" href="shop"></a>

                        <div class="caption_down_content">
                            <h3>Free shipping</h3>
                            <h5>on orders over $299</h5>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li data-preview="<c:url value="/images/banner/item-banner-2.jpg" />"
            data-thumb-url="<c:url value="/images/banner/item-banner-2-100x50.jpg" />"
            data-ulr-link="">
            <div class="slider_caption">
                <div class="caption_wrapper">
                    <div class="caption_up">
                        <div class="caption_up_content">
                            <h3>Get up to<br> 20% off</h3>
                            <h4>on Rum</h4>
                            <h5>more than 50 items</h5>
                        </div>
                    </div>
                    <div class="caption_down">
                        <a class="round-button" href="about"></a>

                        <div class="caption_down_content">
                            <h3>Free shipping</h3>
                            <h5>on orders over $299</h5>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li data-preview="<c:url value="/images/banner/item-banner-1.jpg" />"
            data-thumb-url="<c:url value="/images/banner/item-banner-1-100x50.jpg" />"
            data-ulr-link="">
            <div class="slider_caption">
                <div class="caption_wrapper">
                    <div class="caption_up">
                        <div class="caption_up_content">
                            <h3>Get up to<br> 20% off</h3>
                            <h4>on Vodka</h4>
                            <h5>more than 50 items</h5>
                        </div>
                    </div>
                    <div class="caption_down">
                        <a class="round-button" href="blog"></a>

                        <div class="caption_down_content">
                            <h3>Free shipping</h3>
                            <h5>on orders over $299</h5>
                        </div>
                    </div>
                </div>
            </div>
        </li>
    </ul>
</div>

<div class="motopress-wrapper content-holder clearfix">
    <div class="container">
        <div class="row">
            <div class="span12">
                <div class="row">
                    <div class="span12" data-motopress-type="static"
                         data-motopress-static-file="static/static-slider.php">
                        <div class="slider_off"><!--slider off--></div>
                    </div>
                </div>
                <div class="row">
                    <div class="span12">
                        <div id="post-203" class="page post-203 type-page status-publish hentry">
                            <section class="parallax-box image-parallax-box parallax1">
                                <div class="parallax-content">
                                    <div class="partners_wrapper">
                                        <div class="partners_wrapper_wrap_inner">
                                            <ul>
                                                <li><a href="http://www.hennessy.com/"><img
                                                        class="alignnone size-full wp-image-2176"
                                                        src="http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2015/05/partner1.jpg"
                                                        alt="partner1" width="233" height="144"/></a></li>
                                                <li><a href="http://www.thefamousgrouse.com"><img
                                                        class="alignnone size-full wp-image-2086"
                                                        src="http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2015/04/partner2.jpg"
                                                        alt="partner2" width="233" height="144"/></a>
                                                </li>
                                                <li><a href="http://es.moet.com/"><img
                                                        class="alignnone size-full wp-image-2087"
                                                        src="http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2015/04/partner3.jpg"
                                                        alt="partner3" width="233" height="144"/></a></li>
                                                <li><a href="http://www.gordons-gin.co.uk/"><img
                                                        class="alignnone size-full wp-image-2088"
                                                        src="http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2015/04/partner4.jpg"
                                                        alt="partner4" width="233" height="144"/></a>
                                                </li>
                                                <li><a href="http://www.jimbeam.com/"><img
                                                        class="alignnone size-full wp-image-2089"
                                                        src="http://livedemo00.template-help.com/woocommerce_53953/wp-content/uploads/2015/04/partner5.jpg"
                                                        alt="partner5" width="233" height="144"/></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="banners_wrapper">
                                        <div class="banners_wrapper_wrap_inner">
                                            <div class="row ">
                                                <div class="span5 ">
                                                    <div class="extra-wrap">
                                                        <h4>Big sale<br/> of the year!</h4>

                                                        <h3>save up to 50%</h3>
                                                    </div>
                                                </div>
                                                <div class="span7 ">
                                                    <div class="banner-wrap ">
                                                        <figure class="featured-thumbnail">
                                                            <a href="blog"
                                                               title="buy a 1l bottle for the 750ml price and">
                                                                <img src="<c:url value="/images/banner/banner-2.jpg" />"
                                                                     title="buy a 1l bottle for the 750ml price and"
                                                                     alt=""/>
                                                            </a>
                                                        </figure>
                                                        <div class="banner-wrap_content">
                                                            <h5>buy a 1l bottle for the 750ml price and</h5>

                                                            <p>get 30%<br/> off</p>

                                                            <div class="link-align banner-btn">
                                                                <a href="blog" title="Go" class="btn btn-link"
                                                                   target="_self">Go</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- .banner-wrap (end) -->
                                                </div>
                                            </div>
                                            <!-- .row (end) -->
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                <div class="parallax-bg" data-parallax-type="image"
                                     data-img-url="<c:url value="/images/banner/banner-1.jpg" />"
                                     data-speed="normal" data-invert="false">

                                </div>
                            </section>
                        </div>
                        <div class="content_box banners_wrapper2 ">
                            <div class="row ">
                                <div class="span8 ">
                                    <div class="custom_banner1">
                                        <div class="custom_banner1_wrap_inner">
                                            <div class="extra-wrap">
                                                <h3>100%</h3>
                                                <h4>Great tasting wine with a splash of fruit. Wines for momentous
                                                    encounters.</h4>

                                                <div class="clear"></div>
                                                <!-- .clear (end) -->
                                                <h5>Pure organic grapes</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span4 ">
                                    <div class="custom_banner2">
                                        <div class="custom_banner2_wrap_inner">
                                            <h3><a href="shop">buy today for $31.99</a></h3>
                                        </div>
                                    </div>
                                    <!-- .row (end) -->
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <!-- .content_box (end) -->
                        <%@ include file="shop/services.jsp" %>
                        <%--<%@ include file="shop/featureProduct.jsp" %>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



