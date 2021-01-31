<template>
    <div class="container shopping-cart">
        <div class="content">
            <div class="row">
                <div class="col-md-12 col-lg-12" v-for='(item, index) in customers' :key='index'>
                    <div class="items">
                        <div class="customer">
                            <div class="row">
                                <div class="col-md-3">
                                  <img class="img-fluid mx-auto d-block image" src="https://www.it.iitb.ac.in/frg/wiki/images/thumb/d/dc/User.jpg/960px-User.jpg" alt="">
                                </div>
                                <div class="col-md-6">
                                    <div class="info">
                                        <div class="row">
                                            <div class="col-md-5 product-name">
                                                <div class="customer-name">
                                                    <a class="customer-name" href="#">{{ item.name }}</a>
                                                    <div class="customer-info">
                                                        <div class="customer-info-detail">{{ item.address }}</div>
                                                        <div class="customer-info-detail"><span v-if="item.phoneNumber"> </span>Phone Number: <span
                                                                class="value">{{ item.status }}</span></div>
                                                        <div class="customer-info-detail"><span class="value" v-html="item.typeCode.description"></span></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-8"></div>
                                <div class="col-md-4">
                                    <div class=""></div>
                                    <div class="row align-items-end">
                                        <div class="col-md-6">
                                            <button class="btn btn-primary">Back</button>
                                        </div>
                                        <div class="col-md-6">
                                            <button class="btn btn-success">Okay</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import {getAllCustomer} from "@/common/customer.service";
export default {
  name: 'Customer',
  components: {},
  data() {
    return {customers: []}
  },
  created() {
    this.getCustomers();
  },
  methods: {
    getCustomers() {
      getAllCustomer().then(response => {
        this.customers = response.data;
      })
    }
  }
}
</script>


<style scoped lang='scss'>
    .shopping-cart {
        font-family: 'Montserrat', sans-serif;
    }
    .shopping-cart.dark {
        background-color: #f6f6f6;
    }
    .shopping-cart .content {
        box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
        background-color: white;
    }
    .shopping-cart .block-heading {
        padding-top: 50px;
        margin-bottom: 40px;
        text-align: center;
    }
    .shopping-cart .block-heading p {
        text-align: center;
        max-width: 420px;
        margin: auto;
        opacity: 0.7;
    }
    .shopping-cart .dark .block-heading p {
        opacity: 0.8;
    }
    .shopping-cart .block-heading h1,
    .shopping-cart .block-heading h2,
    .shopping-cart .block-heading h3 {
        margin-bottom: 1.2rem;
        color: #3b99e0;
    }
    .shopping-cart .items {
        margin: auto;
    }
    .shopping-cart .items .product {
        margin-bottom: 20px;
        padding-top: 20px;
        padding-bottom: 20px;
    }
    .shopping-cart .items .product .info {
        padding-top: 0px;
        text-align: center;
    }
    .shopping-cart .items .product .info .product-name {
        font-weight: 600;
    }
    .shopping-cart .items .product .info .product-name .product-info {
        font-size: 14px;
        margin-top: 15px;
    }
    .shopping-cart .items .product .info .product-name .product-info .product-info-detail {
        margin-bottom: 15px;
    }
    .shopping-cart .items .product .info .product-name .product-info .value {
        font-weight: 400;
    }
    .shopping-cart .items .product .info .quantity .quantity-input {
        margin: auto;
        width: 80px;
    }
    .shopping-cart .items .product .info .price {
        margin-top: 15px;
        font-weight: bold;
        font-size: 22px;
    }
    .shopping-cart .summary {
        border-top: 2px solid #5ea4f3;
        background-color: #f7fbff;
        height: 100%;
        padding: 30px;
    }
    .shopping-cart .summary h3 {
        text-align: center;
        font-size: 1.3em;
        font-weight: 600;
        padding-top: 20px;
        padding-bottom: 20px;
    }
    .shopping-cart .summary .summary-item:not(:last-of-type) {
        padding-bottom: 10px;
        padding-top: 10px;
        border-bottom: 1px solid rgba(0, 0, 0, 0.1);
    }
    .shopping-cart .summary .text {
        font-size: 1em;
        font-weight: 600;
    }
    .shopping-cart .summary .price {
        font-size: 1em;
        float: right;
    }
    .shopping-cart .summary button {
        margin-top: 20px;
    }
    .control-buttons {
        display: flex;
        flex-direction: column;
    }
    @media (min-width: 768px) {
        .shopping-cart .items .product .info {
            padding-top: 25px;
            text-align: left;
        }
        .shopping-cart .items .product .info .price {
            font-weight: bold;
            font-size: 22px;
            top: 17px;
        }
        .shopping-cart .items .product .info .quantity {
            text-align: center;
        }
        .shopping-cart .items .product .info .quantity .quantity-input {
            padding: 4px 10px;
            text-align: center;
        }
    }
</style>