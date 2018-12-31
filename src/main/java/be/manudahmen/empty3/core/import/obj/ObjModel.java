package be.manudahmen.empty3.core.imports.obj;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Representable;

/**
 * Created by Win on 24-12-18.
 */
public class ObjModel {
    public final String vertex_vertice = "v";
    public final String texture_vertice = "vt";
    public final String normals_vertice = "vn";
    public final String paramter_vertice = "vp";
    public final String form_matrix = "form_matrix";
    public final String form_bspline = "form_bspline";
    public final String form_cardinal = "cardinal";
    public final String form_cstype = "cstype";
    public final String degree = "deg";
    public final String basis_matrix = "bmat";
    public final String step = "step";
    public final String elements_point = "p";
    public final String elements_line = "l";
    public final String elements_face = "f";
    public final String elements_curv = "curv";
    public final String elements_3dCurv = "curv2";
    public final String elements_surface = "surf";
    public final String body_statement_param = "param";
    public final String body_statement_outer_trimming_loop = "trim";
    public final String body_statement_special_curve = "scrv";
    public final String body_statement_curve = "param";
    public final String body_statement_sp = "sp";
    public final String body_statement_end = "end";
    public final String conn_con = "con";
    public final String group_name = "g";
    public final String group_smoothng = "g";
    public final String group_merging_group = "mg";
    public final String group_object_name = "o";
    public final String renderer_bevel = "bevel";
    public final String renderer_color = "c_interp";
    public final String renderer_dissolve = "d_interp";
    public final String renderer_dissolve_interpolation = "d_interp";
    public final String renderer_details_level = "lod";
    public final String renderer_material_name = "usemtl";
    public final String renderer_material_lib = "mtllib";
    public final String renderer_shadow = "shadow_obj";
    public final String renderer_raytracing = "trace_obj";
    public final String renderer_interpolation_technique = "ctech";
    public final String renderer_approximation_technique = "stech";


    public interface Line {
        Representable parseString();
    }

    public class Vertex {

        private Point3D p = Point3D.O0;

        public Vertex(Point3D p) {
            this.p = p;
        }

        public void parse(String s) {
            String[] split = s.split(" ");
            for (int i = 1; i < 3; i++) {
                p.set(i - 1, Double.parseDouble(split[i]));
            }
        }

        public String toString() {
            return "v " + p.get(0) + " " + p.get(1) + " " + p.get(2) + "\n";
        }
    }

}