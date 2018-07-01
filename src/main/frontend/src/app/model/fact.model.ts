import {User} from "./user";
import {Category} from "./category.model";

export class Fact {
  id: number;
  content: string;
  category: Category;
  createdBy: User
  isAllowed: boolean;
}
