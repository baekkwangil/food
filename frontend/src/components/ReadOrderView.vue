<template>

    <v-data-table
        :headers="headers"
        :items="readOrder"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReadOrderView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            readOrder : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/readOrders'))

            temp.data._embedded.readOrders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.readOrder = temp.data._embedded.readOrders;
        },
        methods: {
        }
    }
</script>

