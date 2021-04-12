var Main = {
    data() {
        const item = {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
        };
        return {
            tableData: Array(20).fill(item)
            ,activeIndex2: '1'
        }

    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        }
    }

};
var Ctor = Vue.extend(Main)
new Ctor().$mount('#app')
