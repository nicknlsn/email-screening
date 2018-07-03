<template>
    <div class="home">
        <input v-model="value" placeholder="enter an integer">
        <!--<p>Message is: {{ value }}</p>-->
        <button v-on:click="submit()">submit</button>
    </div>
</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';
    import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
    import axios from 'axios';

    @Component({
        components: {
            HelloWorld,
        }
    })
    export default class IntegerPalindrome extends Vue {

        public value: string;

        constructor() {
            super();
            this.value = ''
        }

        public test() {
            axios.get('/api/v1/test').then((response) => {
            });
        }

        public submit() {
            axios.get('/api/v1/integer-palindrome', {
                params: {
                    value: this.value
                }
            }).then((response) => {

            })
        }
    }
</script>
