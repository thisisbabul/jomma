<template src="./InvestStocks.html"></template>
<style scoped src="./InvestStocks.css"></style>

<script>
import axios from "axios";

export default {
  name: 'InvestStocks',
  data() {
    return {
      products: [],
      selectedProducts: [],
      sortedData: [],
      sortedByASC: true,
    }
  },
  mounted() {
    axios
        .get('http://localhost:8081/api/v1/products')
        .then(response => {
          this.products = response.data.content;
          this.sortedData = this.products;
        })
        .catch(error => {
          console.log(error)
        })
  },
  methods: {
    sortList(sortBy) {
      if (this.sortedByASC) {
        this.sortedData.sort((x, y) => (x[sortBy] > y[sortBy] ? -1 : 1));
        this.sortedByASC = false;
      } else {
        this.sortedData.sort((x, y) => (x[sortBy] < y[sortBy] ? -1 : 1));
        this.sortedByASC = true;
      }
    },
    isAddedProduct(product) {
      if (this.selectedProducts.length > 0) {
        let selectedProduct = this.selectedProducts.find(p => p.productId === product.productId);
        return !!selectedProduct;
      }
      return false;
    },
    addProduct(product) {
      this.selectedProducts.push({
        productId: product.productId,
        productName: product.productName,
        productCode: product.productCode,
        unitPrice: product.unitPrice,
        gainLoss: product.gainLoss,
        yearToDate: product.yearToDate,
        activeStatus: product.activeStatus
      })
    },
    removeProduct(selectProduct) {
      this.selectedProducts = this.selectedProducts.filter(product => product.productId !== selectProduct.productId)
    },
    submitProducts() {
      axios
          .post('http://localhost:8081/api/v1/products', this.selectedProducts)
          .then(response => {
            console.log(response.data);
          })
          .catch(error => {
            console.log(error)
          })
    }
  }
}
</script>