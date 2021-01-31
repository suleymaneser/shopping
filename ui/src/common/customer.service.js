import {get} from "@/common/api.service";


export function getById(id) {
    return get('/ap/customer/' + id);
}

export function getAllCustomer() {
    return get('/api/customer/getAllCustomer');
}