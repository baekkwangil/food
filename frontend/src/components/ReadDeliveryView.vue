<template>

    <v-data-table
        :headers="headers"
        :items="readDelivery"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReadDeliveryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            readDelivery : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/readDeliveries'))

            temp.data._embedded.readDeliveries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.readDelivery = temp.data._embedded.readDeliveries;
        },
        methods: {
        }
    }
</script>

