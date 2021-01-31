import {get} from "@/common/api.service";


export function getById(id) {
    return get('/api/product/' + id);
}

export function getAllProduct() {
    return get('/api/product/getAllProduct');
}