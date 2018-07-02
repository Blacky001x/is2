import {User} from "./user.model";
import {Category} from "./category.model";

export class Fact {
  id: number;
  content: string;
  category: Category;
  createdBy: User;
  allowed: boolean;
}
